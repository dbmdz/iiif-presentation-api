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
package com.datazuul.iiif.presentation.business.service.impl;

import com.datazuul.iiif.presentation.api.model.Manifest;
import com.datazuul.iiif.presentation.backend.repository.PresentationRepository;
import com.datazuul.iiif.presentation.business.service.PresentationSecurityService;
import com.datazuul.iiif.presentation.business.service.PresentationService;
import com.datazuul.iiif.presentation.model.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ralf Eichinger (ralf.eichinger at gmail.com)
 */
@Service
public class PresentationServiceImpl implements PresentationService {

  @Autowired
  private PresentationRepository presentationRepository;

  @Autowired(required = false)
  private PresentationSecurityService presentationSecurityService;

  @Override
  public Manifest getManifest(String identifier) throws NotFoundException {
    if (presentationSecurityService != null && !presentationSecurityService.
            isAccessAllowed(identifier)) {
      throw new NotFoundException(); // TODO maybe throw an explicitely access disallowed exception
    }
    return presentationRepository.getManifest(identifier);
  }

}
