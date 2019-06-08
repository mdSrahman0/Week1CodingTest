// Java program to create a Singleton class that's thread Safe
public class Singleton
{
    // we make the instance private so only the getInstance() method can access it.
    private static Singleton instance;

    // a private constructor.
    private Singleton() {
    }

    // a synchronized method to ensure that multiple
    // threads don't access it simultaneously.
    synchronized public static Singleton getInstance() {
        // if instance is null, initialize
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
} 