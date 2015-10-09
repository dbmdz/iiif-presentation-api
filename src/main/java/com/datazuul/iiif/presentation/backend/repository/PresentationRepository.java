/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datazuul.iiif.presentation.backend.repository;

import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.model.NotFoundException;

/**
 * Interface to be implemented by project/user of this library. Place your implementation into
 * package "org.mdz.iiifserver.backend.repository.impl".
 *
 * @author Ralf Eichinger (ralf.eichinger at gmail.com)
 */
public interface PresentationRepository {

  /**
   * @param identifier unique id for IIIF resource
   * @return Manifest specifying presentation for IIIF resource
   * @throws com.datazuul.iiif.presentation.model.NotFoundException in case Manifest does not exist
   * or can not be delivered
   */
  Manifest getManifest(String identifier) throws NotFoundException;
}
