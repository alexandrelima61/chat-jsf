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

package br.com.Chate.Classes.convert;

import br.com.Chate.Classes.model.system.AvailableThemes.AvailableThemes;
import br.com.Chate.Classes.model.system.AvailableThemes.Theme;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * ThemeConverter
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@FacesConverter("br.com.Chate.Classes.convert.ThemeConverter")
public class ThemeConverter implements Converter {

	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		return AvailableThemes.getInstance().getThemeForName(value);
	}

	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		return ((Theme) value).getName();
	}
}
