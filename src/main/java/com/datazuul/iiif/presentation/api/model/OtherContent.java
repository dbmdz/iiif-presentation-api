/*
 * Copyright 2015 Ralf Eichinger <ralf.eichinger@bsb-muenchen.de>.
 *
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
package com.datazuul.iiif.presentation.api.model;

/**
 *
 * @author Ralf Eichinger <ralf.eichinger@bsb-muenchen.de>
 */
public class OtherContent {
    private String id; // required
    private final String type = "oa:Annotation"; // required
}
