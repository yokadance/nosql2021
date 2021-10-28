package com.example.demo.mapper;

import com.example.demo.dto.role.request.CreateRoleDto;
import com.example.demo.dto.role.response.ReadRoleDto;
import com.example.demo.model.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface RoleMapper {
  ReadRoleDto roleToReadRoleDto(Role role);

  Role createRoleDtoTORole(CreateRoleDto createRoleDto);
}
