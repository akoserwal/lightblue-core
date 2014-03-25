/*
 Copyright 2013 Red Hat, Inc. and/or its affiliates.

 This file is part of lightblue.

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.redhat.lightblue.metadata;

import com.redhat.lightblue.Response;
import java.io.Serializable;

/**
 * Metadata manager interface
 */
public interface Metadata extends Serializable {

    /**
     * Get all dependencies using default versions. If the entity has a default version defined the dependencies for
     * that default version is included. If the entity does not have a default version defined then it is added into the
     * data error section of the response.
     *
     * @return Response with an array of Dependency object data.
     */
    Response getDependencies();

    /**
     * Get all dependencies for the given entity using default versions. If the entity has a default version defined the
     * dependencies for that default version is included. If the entity does not have a default version defined then it
     * is added into the data error section of the response.
     *
     * @return Response with an array of Dependency object data.
     */
    Response getDependencies(String entityName);

    /**
     * Get all dependencies for the given entity using the given version.
     *
     * @return Response with an array of Dependency object data.
     */
    Response getDependnecies(String entityName, String version);

    /**
     * Get all entity and field access for all entities using default versions. If the entity has a default version
     * defined the access for that default version is included. If the entity does not have a default version defined
     * then it is added into the data error section of the response.
     *
     * @return Response with array of Map<String, MetadataAccess> data, where key is the entity name
     */
    Response getAccess();

    /**
     * Get all entity and field access for the given entity using default versions. If the entity has a default version
     * defined the access for that default version is included. If the entity does not have a default version defined
     * then it is added into the data error section of the response.
     *
     * @return Response with array of Map<String, MetadataAccess> data, where key is the entity name
     */
    Response getAccess(String entityName);

    /**
     * Get all entity and field access for the given entity using the given version.
     *
     * @return Response with array of Map<String, MetadataAccess> data, where key is the entity name
     */
    Response getAccess(String entityName, String version);

    /**
     * Returns a particular version of the entity metadata if forceVersion is true. Otherwise, it returns the default
     * version if the specific version is disabled
     */
    EntityMetadata getEntityMetadata(String entityName, String version, boolean forceVersion);

    /**
     * Returns the names of all entities
     */
    String[] getEntityNames();

    /**
     * Returns all versions of an entity
     */
    Version[] getEntityVersions(String entityName);

    /**
     * Creates a new entity metadata
     */
    void createNewMetadata(EntityMetadata md);

    /**
     * Sets the status of a particular version of an entity
     */
    void setMetadataStatus(String entityName,
                           String version,
                           MetadataStatus newStatus,
                           String comment);

}
