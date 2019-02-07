package metube.service;

import org.modelmapper.ModelMapper;

public class MappingServiceImpl implements MappingService{
    @Override
    public <T> T map(Object obj, Class<T> klass) {
        return new ModelMapper()
                .map(obj, klass);
    }
}
