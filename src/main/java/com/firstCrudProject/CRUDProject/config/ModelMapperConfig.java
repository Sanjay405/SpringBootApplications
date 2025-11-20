package com.firstCrudProject.CRUDProject.config;


import com.firstCrudProject.CRUDProject.dto.EmployeeDTO;
import com.firstCrudProject.CRUDProject.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Configuration
    public class MapperConfig {

        @Bean
        public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true);

            // 👇 Important: Skip ID while mapping DTO → Entity
            modelMapper.typeMap(EmployeeDTO.class, Employee.class)
                    .addMappings(mapper -> mapper.skip(Employee::setEmpId));

            return modelMapper;
        }
    }

}

