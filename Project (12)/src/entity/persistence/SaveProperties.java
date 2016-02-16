package entity.persistence;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entity.Filepaths;
import entity.properties.Property;
import exception.AlreadyRegisteredException;
import exception.FileException;
import exception.UserNotFoundException;

public class SaveProperties {

	private static SaveProperties instance = null;
	private String fileName;
	private String tmpFileName;

	private SaveProperties(String fileName, String tmpFileName) {
		this.fileName = fileName;
		this.tmpFileName = tmpFileName;

		// If user file doesn't exist, create a new file
		File file = new File(fileName);
		if (!file.exists()) {
			initFile();
		}
	}

	public static synchronized final SaveProperties getInstance() {
		if (SaveProperties.instance == null) {
			SaveProperties.instance = new SaveProperties(Filepaths.PROPERTIES_VALUE_DATABASE_FILENAME,
					Filepaths.PROPERTIES_VALUE_DATABASE_TMP);
		}
		return instance;
	}

	public void insertProperties(Property prop)
			throws IOException, ClassNotFoundException, AlreadyRegisteredException, FileException {
		File file = new File(fileName);
		File tmp = new File(tmpFileName);

		FileInputStream fis = null;
		ObjectInputStream is = null;
		FileOutputStream fos = null;
		ObjectOutputStream os = null;

		Property foundProperty = searchProperty(prop.getMunicipality(), prop.getProvince(), prop.getAddress(),
				prop.getHouseNum());
		if (foundProperty != null) {
			// Property already registered
			throw new AlreadyRegisteredException();
		}

		tmp.delete();

		if (!file.renameTo(tmp)) {
			// Failed to rename
			throw new FileException();
		}

		try {
			fos = new FileOutputStream(file);
			os = new ObjectOutputStream(fos);
			fis = new FileInputStream(tmp);
			is = new ObjectInputStream(fis);

			while (true) {
				// Copy all object from old file (tmp) to a new file
				Object o = deserializeObject(is);
				serializeObject(o, os);
			}
		} catch (EOFException e) {
			// End of file, add property
			serializeObject(prop, os);
		} finally {
			closeFileInputStream(fis);
			closeObjectInputStream(is);
			closeFileOutputStream(fos);
			closeObjectOutputStream(os);
			tmp.delete();
		}
	}

	public void deleteProperty(String municipality, String province, String address, String houseNum)
			throws IOException, ClassNotFoundException, UserNotFoundException, FileException {
		File file = new File(fileName);
		File tmp = new File(tmpFileName);

		FileInputStream fis = null;
		ObjectInputStream is = null;
		FileOutputStream fos = null;
		ObjectOutputStream os = null;

		if (searchProperty(municipality, province, address, houseNum) == null) {
			// Property not found
			throw new UserNotFoundException();
		}

		tmp.delete();

		if (!file.renameTo(tmp)) {
			// Failed to rename
			throw new FileException();
		}

		try {
			fis = new FileInputStream(tmp);
			is = new ObjectInputStream(fis);
			fos = new FileOutputStream(file);
			os = new ObjectOutputStream(fos);

			while (true) {
				Object o = deserializeObject(is);
				if (o instanceof Property) {
					// Object is property
					Property prop = (Property) o;
					if (!prop.getMunicipality().equals(municipality) || !prop.getProvince().equals(province)
							|| !prop.getAddress().equals(address) || !prop.getHouseNum().equals(houseNum)) {
						// Copy only if it is not object to be deleted
						serializeObject(prop, os);
					}
				}
			}
		} catch (EOFException e) {
			// End of file, break
		} finally {
			closeFileInputStream(fis);
			closeObjectInputStream(is);
			closeFileOutputStream(fos);
			closeObjectOutputStream(os);
			tmp.delete();
		}
	}

	public Property searchProperty(String municipality, String province, String address, String houseNum)
			throws ClassNotFoundException, IOException {
		File file = new File(fileName);

		FileInputStream fs = null;
		ObjectInputStream is = null;

		try {
			fs = new FileInputStream(file);
			is = new ObjectInputStream(fs);

			while (true) {
				Object o = deserializeObject(is);
				if (o instanceof Property) {
					Property prop = (Property) o;
					if (prop.getMunicipality().equals(municipality) && prop.getProvince().equals(province)
							&& prop.getAddress().equals(address) && prop.getHouseNum().equals(houseNum)) {
						return prop;
					}
				}
			}
		} catch (EOFException e) {
			// Object not found
			return null;
		} finally {
			closeFileInputStream(fs);
			closeObjectInputStream(is);
		}
	}

	public static void serializeObject(Object o, ObjectOutputStream os) throws IOException {
		os.writeObject(o);
	}

	public static Object deserializeObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
		return is.readObject();
	}

	public ArrayList<Property> getListOfProperties() throws IOException, ClassNotFoundException {
		File file = new File(fileName);

		FileInputStream fs = null;
		ObjectInputStream is = null;

		ArrayList<Property> list = new ArrayList<>();

		try {
			fs = new FileInputStream(file);
			is = new ObjectInputStream(fs);

			while (true) {
				Object o = deserializeObject(is);
				if (o instanceof Property) {
					Property prop = (Property) o;
					list.add(prop);
				}
			}
		} catch (EOFException e) {
			// End of File
			return list;
		} finally {
			closeFileInputStream(fs);
			closeObjectInputStream(is);
		}
	}

	public void closeFileOutputStream(FileOutputStream fs) throws IOException {
		if (fs != null) {
			fs.close();
		}
	}

	public void closeObjectOutputStream(ObjectOutputStream os) throws IOException {
		if (os != null) {
			os.close();
		}
	}

	public void closeFileInputStream(FileInputStream fs) throws IOException {
		if (fs != null) {
			fs.close();
		}
	}

	public void closeObjectInputStream(ObjectInputStream is) throws IOException {
		if (is != null) {
			is.close();
		}
	}

	public void initFile() {
		// Create a new empty file
		FileOutputStream fs = null;
		ObjectOutputStream os = null;

		try {
			fs = new FileOutputStream(fileName);
			os = new ObjectOutputStream(fs);
		} catch (IOException e) {
			// Error while writing to file
			e.printStackTrace();
		} finally {
			try {
				closeFileOutputStream(fs);
				closeObjectOutputStream(os);
			} catch (IOException e) {
				// Error while closing file
				e.printStackTrace();
			}
		}
	}
}