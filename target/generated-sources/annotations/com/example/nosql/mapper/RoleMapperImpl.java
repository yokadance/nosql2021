package com.example.nosql.mapper;

import com.example.nosql.dto.role.request.CreateRoleDto;
import com.example.nosql.dto.role.response.ReadRoleDto;
import com.example.nosql.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-06T23:49:01-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public ReadRoleDto roleToReadRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        ReadRoleDto readRoleDto = new ReadRoleDto();

        readRoleDto.setId( role.getId() );
        readRoleDto.setName( role.getName() );

        return readRoleDto;
    }

    @Override
    public Role createRoleDtoTORole(CreateRoleDto createRoleDto) {
        if ( createRoleDto == null ) {
            return null;
        }

        Role role = new Role();

        if ( createRoleDto.getId() != null ) {
            role.setId( String.valueOf( createRoleDto.getId() ) );
        }
        role.setName( createRoleDto.getName() );

        return role;
    }
}
