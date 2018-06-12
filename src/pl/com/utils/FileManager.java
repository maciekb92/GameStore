package pl.com.utils;

import pl.com.data.GameStore;

import java.io.*;

public class FileManager {
    public static final String FILE_NAME = "GameStore.o";

    public void writeGameStoreToFile(GameStore gameStore) {
        try(FileOutputStream fos = new FileOutputStream(FILE_NAME); ObjectOutputStream oos = new ObjectOutputStream(fos);
            ) {
                oos.writeObject(gameStore);
        } catch(FileNotFoundException e) {
            System.err.println("File " + FILE_NAME +  " not found");
        } catch(IOException e) {
            System.err.println("Error during save data to " + FILE_NAME + " file");
        }
    }

    public GameStore readGameStoreFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        GameStore gameStore = null;
        try(FileInputStream fis = new FileInputStream(FILE_NAME); ObjectInputStream ois = new ObjectInputStream(fis);
            ) {
                gameStore = (GameStore)ois.readObject();
        } catch(FileNotFoundException e) {
            System.err.println("File " + FILE_NAME + " not found");
            throw e;
        } catch(IOException e) {
            System.err.println("Error during save data to " + FILE_NAME + " file");
            throw e;
        } catch(ClassNotFoundException e) {
            System.err.println("Incorrect file format");
            throw e;
        }
        return gameStore;
    }
}
