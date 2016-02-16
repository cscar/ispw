package entity.persistence;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entity.Administrator;
import entity.Customer;
import entity.Filepaths;
import entity.Scout;
import exception.AlreadyRegisteredException;
import exception.FileException;
import exception.UserNotFoundException;

public class Save {

	private static Save instance = null;
	private String fileName;
	private String tmpFileName;

	private Save(String fileName, String tmpFileName) {
		this.fileName = fileName;
		this.tmpFileName = tmpFileName;

		// If user file doesn't exist, create a new file
		File file = new File(fileName);
		if (!file.exists()) {
			initFile();
		}
	}

	public static synchronized final Save getInstance() {
		if (Save.instance == null) {
			Save.instance = new Save(Filepaths.USERS_DATABASE_FILENAME, Filepaths.USERS_DATABASE_TMP);
		}
		return instance;
	}

	public void insertCustomer(Customer customer)
			throws AlreadyRegisteredException, FileException, ClassNotFoundException, IOException {
		File file = new File(fileName);
		File tmp = new File(tmpFileName);

		FileOutputStream fos = null;
		ObjectOutputStream os = null;
		FileInputStream fis = null;
		ObjectInputStream is = null;

		if (searchUser(customer.getEmail()) != null) {
			// Email already registered
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
				// Copy all objects from old file (tmp) to a new file
				Object o = deserializeObject(is);
				serializeObject(o, os);
			}
		} catch (EOFException e) {
			// End of file, add customer
			serializeObject(customer, os);
		} finally {
			closeFileInputStream(fis);
			closeObjectInputStream(is);
			closeFileOutputStream(fos);
			closeObjectOutputStream(os);
			tmp.delete();
		}
	}

	public void insertAdministrator(Administrator admin)
			throws IOException, ClassNotFoundException, AlreadyRegisteredException, FileException {
		File file = new File(fileName);
		File tmp = new File(tmpFileName);

		FileOutputStream fos = null;
		ObjectOutputStream os = null;
		FileInputStream fis = null;
		ObjectInputStream is = null;

		if (searchUser(admin.getEmail()) != null) {
			// Email already registered
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
			// End of file, add customer
			serializeObject(admin, os);
		} finally {
			closeFileInputStream(fis);
			closeObjectInputStream(is);
			closeFileOutputStream(fos);
			closeObjectOutputStream(os);
			tmp.delete();
		}
	}

	public void insertScout(Scout scout)
			throws IOException, ClassNotFoundException, AlreadyRegisteredException, FileException {
		File file = new File(fileName);
		File tmp = new File(tmpFileName);

		FileOutputStream fos = null;
		ObjectOutputStream os = null;
		FileInputStream fis = null;
		ObjectInputStream is = null;

		if (searchUser(scout.getEmail()) != null) {
			// Email already registered
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
			// End of file, add customer
			serializeObject(scout, os);
		} finally {
			closeFileInputStream(fis);
			closeObjectInputStream(is);
			closeFileOutputStream(fos);
			closeObjectOutputStream(os);
			tmp.delete();
		}
	}

	public void deleteUser(String email)
			throws IOException, ClassNotFoundException, FileException, UserNotFoundException {
		File file = new File(fileName);
		File tmp = new File(tmpFileName);

		FileInputStream fis = null;
		ObjectInputStream is = null;
		FileOutputStream fos = null;
		ObjectOutputStream os = null;

		if (searchUser(email) == null) {
			// Email already registered
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
				if (o instanceof Customer) {
					// Object is customer
					Customer customer = (Customer) o;
					if (!customer.getEmail().equals(email)) {
						// Copy only if it is not object to be deleted
						serializeObject(customer, os);
					}
				}
				if (o instanceof Administrator) {
					// Object is administrator
					Administrator administrator = (Administrator) o;
					if (!administrator.getEmail().equals(email)) {
						// Copy only if it is not object to be deleted
						serializeObject(administrator, os);
					}
				}
				if (o instanceof Scout) {
					// Object is scout
					Scout scout = (Scout) o;
					if (!scout.getEmail().equals(email)) {
						// Copy only if it is not object to be deleted
						serializeObject(scout, os);
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

	public Object searchUser(String email) throws ClassNotFoundException, IOException {
		File file = new File(fileName);
		
		FileInputStream fs = null;
		ObjectInputStream is = null;

		try {
			fs = new FileInputStream(file);
			is = new ObjectInputStream(fs);
			while (true) {
				Object o = deserializeObject(is);
				if (o instanceof Customer) {
					Customer customer = (Customer) o;
					if (customer.getEmail().equals(email)) {
						return customer;
					}
				}
				if (o instanceof Administrator) {
					Administrator administrator = (Administrator) o;
					if (administrator.getEmail().equals(email)) {
						return administrator;
					}
				}
				if (o instanceof Scout) {
					Scout scout = (Scout) o;
					if (scout.getEmail().equals(email)) {
						return scout;
					}
				}
			}
		} catch (EOFException e1) {
			// Object not found
			return null;
		} finally {
			closeFileInputStream(fs);
			closeObjectInputStream(is);
		}
	}

	public void serializeObject(Object o, ObjectOutputStream os) throws IOException {
		os.writeObject(o);
	}

	public Object deserializeObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
		return is.readObject();
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
		// Create a new administrator user
		FileOutputStream fs = null;
		ObjectOutputStream os = null;

		try {
			fs = new FileOutputStream(fileName);
			os = new ObjectOutputStream(fs);
			serializeObject(new Administrator("admin", "password"), os);
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
