package metube.service;

public interface MappingService {
    <T> T map(Object obj, Class<T> klass);
}
