package com.example.nosql.service;

import com.example.nosql.dto.role.request.CreateRoleDto;
import com.example.nosql.dto.role.response.ReadRoleDto;
import com.example.nosql.mapper.RoleMapper;
import com.example.nosql.repository.RoleRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  private final RoleRepository roleRepository;
  private final RoleMapper roleMapper;

  public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
    this.roleRepository = roleRepository;
    this.roleMapper = roleMapper;
  }

  public List<ReadRoleDto> listRoles() {
    var roles = this.roleRepository.findAll();

    return roles.stream().map(this.roleMapper::roleToReadRoleDto).collect(Collectors.toList());
  }

  public ReadRoleDto createRole(CreateRoleDto createRoleDto) {
    var role = this.roleMapper.createRoleDtoTORole(createRoleDto);
    this.roleRepository.save(role);
    return this.roleMapper.roleToReadRoleDto(role);
  }



}
