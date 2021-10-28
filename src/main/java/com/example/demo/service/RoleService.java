package com.example.demo.service;

import com.example.demo.dto.role.request.CreateRoleDto;
import com.example.demo.dto.role.response.ReadRoleDto;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.repository.RoleRepository;
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
