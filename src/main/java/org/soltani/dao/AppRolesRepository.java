package org.soltani.dao;

import org.soltani.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppRolesRepository extends JpaRepository<AppRole,Long> {
     AppRole findByRoleName(String rolename);
}
