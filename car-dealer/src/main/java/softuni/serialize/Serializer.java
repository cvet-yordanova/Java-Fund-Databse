package softuni.serialize;


public interface Serializer {
    <T> void serialize(T o, String fileName);
    <T> T deserialize(Class<T> classT, String fileName);
}
