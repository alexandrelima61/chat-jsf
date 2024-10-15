/*
 * Copyright 2014 jalima.
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
package br.com.Chate.Classes.model.system.AvailableThemes;

/**
 *
 * @author jalima
 */
public class Theme {

    private String name;
    private String image;

    public Theme() {
    }

    public Theme(final String name, final String image) {
        this.name = name;
        this.image = image;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getImage() {
        return image;
    }

    public final void setImage(final String image) {
        this.image = image;
    }
}
