package com.example.demo.controller;

import com.example.demo.dto.role.request.CreateRoleDto;
import com.example.demo.dto.role.response.ReadRoleDto;
import com.example.demo.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roles")
@SecurityRequirement(name = "bearerAuth")
public class RoleController {

  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping
  @Operation(summary = "Este endpoint lista roles")
  ResponseEntity<List<ReadRoleDto>> listRoles() {
    return ResponseEntity.ok(this.roleService.listRoles());
  }

  @PostMapping //EndPOINT
  @Operation(summary = "Crear un Rol")
  ResponseEntity<ReadRoleDto> createRole(@RequestBody CreateRoleDto createRoleDto) { // ReadROleDto CREADO EN RoleService transformado por Mapper
    return ResponseEntity.ok(this.roleService.createRole(createRoleDto));
  }
}
