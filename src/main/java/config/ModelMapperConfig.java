package config;

import models.service.UserCreateServiceModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;


public class ModelMapperConfig {
    @Produces
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(HttpServletRequest.class, UserCreateServiceModel.class)
                .addMappings(new PropertyMap<>() {
                    @Override
                    protected void configure() {
                        map().setUsername("username");
                    }
                });
        return mapper;
    }
}
