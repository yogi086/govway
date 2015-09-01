/*
 * OpenSPCoop v2 - Customizable SOAP Message Broker 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2015 Link.it srl (http://link.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openspcoop2.generic_project.web.impl.jsf2.input;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Method;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.openspcoop2.generic_project.web.form.ActionListener;
import org.openspcoop2.generic_project.web.form.CostantiForm;
import org.openspcoop2.generic_project.web.form.Form;
import org.openspcoop2.generic_project.web.impl.jsf2.utils.Utils;
import org.openspcoop2.generic_project.web.input.FieldType;
import org.openspcoop2.generic_project.web.input.FormField;
import org.openspcoop2.generic_project.web.logging.LoggerManager;

/**
 * Implementazione di un elemento di input di tipo generico.
 * 
 * @author Pintori Giuliano (pintori@link.it)
 *  @author $Author$
 * @version $Rev$, $Date$ 
 *
 */
public abstract class BaseFormField<T> implements FormField<T>{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String name;
	
	protected String id;

	protected String label;

	protected String label2;

	protected T value;

	protected T value2;

	protected T defaultValue;

	protected T defaultValue2;

	protected FieldType type;
	
	protected String _value_type;

	protected boolean interval;

	protected boolean autoComplete ;

	protected Form form;

	protected String fieldsToUpdate;
	
	protected String execute;

	protected boolean rendered ;

	protected boolean required ;

	protected String requiredMessage;

	protected String note;

	protected boolean enableManualInput;

	protected boolean disabled;

	protected boolean confirm ;

	protected boolean redisplay;

	protected String style;
	
	protected String styleClass;

	protected String pattern;
	
	protected int width;	

	protected String handlerMethodPrefix = null;
	
	protected AffineTransform affineTransform = null;
	
	protected FontRenderContext fontRenderContext = null;
	
	protected String fontName;
	protected int fontStyle, fontSize;
	
	protected ActionListener actionListener;	
	
	protected Integer maxSelectItemsWidth = null; 
	protected Integer defaultSelectItemsWidth = null;
	protected Integer selectItemsWidth = null;
	protected boolean checkItemWidth =false;
	
	protected List<SelectItem> elencoSelectItems;

	protected List<org.openspcoop2.generic_project.web.input.SelectItem> elencoHtmlOptions; 

	public String getExecute() {
		return this.execute;
	}

	public void setExecute(String execute) {
		this.execute = execute;
	}

	@Override
	public boolean isAutoComplete() {
		return this.autoComplete;
	}

	@Override
	public void setAutoComplete(boolean autoComplete) {
		this.autoComplete = autoComplete;
	}

	@Override
	public Form getForm() {
		return this.form;
	}

	@Override
	public void setForm(Form search) {
		this.form = search;
	}

	@Override
	public String getFieldsToUpdate() {
		return this.fieldsToUpdate;
	}

	@Override
	public void setFieldsToUpdate(String fieldsToUpdate) {
		this.fieldsToUpdate = fieldsToUpdate;
	}

	public BaseFormField(){
		this.autoComplete = false;
		this.interval = false;
		this.rendered = true;
		this.disabled = false;
		this.enableManualInput =false;
		this.required = false;
		this.requiredMessage = "inputField.requiredMessageDefault";
		this.style = null ; //"width:412px;";
		this.width = 412;
		this.fontName = "Verdana";
		this.fontSize = 11;
		this.fontStyle = Font.PLAIN;
		this.defaultSelectItemsWidth = this.width ;
		this.maxSelectItemsWidth = 700;
		this.checkItemWidth = false;
	}
	
	@Override
	public String getLabel() {
		try{
			String tmp = Utils.getInstance().getMessageFromResourceBundle(this.label);

			if(tmp != null && !tmp.startsWith("?? key ") && !tmp.endsWith(" not found ??"))
				return tmp;
		}catch(Exception e){}

		return this.label;
	}

	@Override
	public String getLabel2() {
		try{
			String tmp = Utils.getInstance().getMessageFromResourceBundle(this.label2);

			if(tmp != null && !tmp.startsWith("?? key ") && !tmp.endsWith(" not found ??"))
				return tmp;
		}catch(Exception e){}

		return this.label2;
	}

	@Override
	public String getRequiredMessage() {

		try{
			String tmp = Utils.getInstance().getMessageFromResourceBundle(this.requiredMessage);

			if(tmp != null && !tmp.startsWith("?? key ") && !tmp.endsWith(" not found ??")){
				return tmp;
			} else {
				tmp = Utils.getInstance().getMessageFromCommonsResourceBundle(this.requiredMessage);
				if(tmp != null && !tmp.startsWith("?? key ") && !tmp.endsWith(" not found ??")){
					return this.label != null ? (this.label + ": "+ tmp) : tmp;
				}
			}
		}catch(Exception e){}

		return this.requiredMessage;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public FieldType getType() {
		return this.type;
	}

	@Override
	public void setType(FieldType type) {
		this.type = type;
	}

	@Override
	public boolean isInterval() {
		return this.interval;
	}

	@Override
	public void setInterval(boolean interval) {
		this.interval = interval;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void setLabel2(String label) {
		this.label2 = label;
	}

	@Override
	public T getValue2() {
		return this.value2;
	}

	@Override
	public void setValue2(T value2) {
		this.value2 = value2;
	}

	@Override
	public void reset(){
		this.value = this.defaultValue;
		this.value2 = this.defaultValue2;
	}

	@Override
	public <C> C getValue(Class<C> clazz) {
		return clazz.cast(this.value);
	}

	@Override
	public <C> C getValue2(Class<C> clazz) {
		return clazz.cast(this.value2);
	}

	

	@Override
	public boolean isRendered() {
		return this.rendered;
	}

	@Override
	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	@Override
	public T getDefaultValue() {
		return this.defaultValue;
	}

	@Override
	public void setDefaultValue(T defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public T getDefaultValue2() {
		return this.defaultValue2;
	}

	@Override
	public void setDefaultValue2(T defaultValue2) {
		this.defaultValue2 = defaultValue2;
	}

	@Override
	public boolean isRequired() {
		return this.required;
	}

	@Override
	public void setRequired(boolean required) {
		this.required = required;
	}

	@Override
	public void setRequiredMessage(String requiredMessage) {
		this.requiredMessage = requiredMessage;
	}

	@Override
	public boolean isEnableManualInput() {
		return this.enableManualInput;
	}

	@Override
	public void setEnableManualInput(boolean enableManualInput) {
		this.enableManualInput = enableManualInput;
	}

	@Override
	public boolean isDisabled() {
		return this.disabled;
	}

	@Override
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public String getNote() {
		return this.note;
	}

	@Override
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public boolean isConfirm() {
		return this.confirm;
	}

	@Override
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	@Override
	public boolean isRedisplay() {
		return this.redisplay;
	}

	@Override
	public void setRedisplay(boolean redisplay) {
		this.redisplay = redisplay;
	}

	@Override
	public String getStyle() {
		return this.style;
	}

	@Override
	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String getHandlerMethodPrefix() {
		return this.handlerMethodPrefix;
	}

	@Override
	public void setHandlerMethodPrefix(String handlerMethodPrefix) {
		this.handlerMethodPrefix = handlerMethodPrefix;
	}

	@Override
	public String getPattern() {
		return this.pattern;
	}

	@Override
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
 
	@Override
	public String getFontName() {
		return this.fontName;
	}
	@Override
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	@Override
	public int getFontStyle() {
		return this.fontStyle;
	}
	@Override
	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}
	@Override
	public int getFontSize() {
		return this.fontSize;
	}
	@Override
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	// Metodi per calcolare lo spazio occupato dalla string passata come parametro

	@Override
	public Integer getFontWidth(String text){
		if(this.fontRenderContext == null){
			if(this.affineTransform == null)
				this.affineTransform = new AffineTransform();
			
			this.fontRenderContext = new FontRenderContext(this.affineTransform,true,true);
		}
		
		Font fontToCheck = new Font(this.fontName, this.fontStyle , this.fontSize);
		Rectangle2D rectangle2d = fontToCheck.getStringBounds(text, this.fontRenderContext);
		return (int) rectangle2d.getWidth(); 
	}
	
	@Override
	public Integer getFontHeight(String text){
		if(this.fontRenderContext == null){
			if(this.affineTransform == null)
				this.affineTransform = new AffineTransform();
			
			this.fontRenderContext = new FontRenderContext(this.affineTransform,true,true);
		}
		
		Font fontToCheck = new Font(this.fontName, this.fontStyle , this.fontSize);
		Rectangle2D rectangle2d = fontToCheck.getStringBounds(text, this.fontRenderContext);
		return (int) rectangle2d.getHeight(); 
	}

	@Override
	public AffineTransform getAffineTransform() {
		return this.affineTransform;
	}

	@Override
	public void setAffineTransform(AffineTransform affineTransform) {
		this.affineTransform = affineTransform;
	}

	@Override
	public FontRenderContext getFontRenderContext() {
		return this.fontRenderContext;
	}

	@Override
	public void setFontRenderContext(FontRenderContext fontRenderContext) {
		this.fontRenderContext = fontRenderContext;
	}

	@Override
	public ActionListener getActionListener() {
		return this.actionListener;
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}
	
	
	// [TODO] Gestire correttamente gli eventhandler
	
	public List<?> fieldAutoComplete(Object val){
		String methodName = null;
		try{
			String message = "fieldAutoComplete Source["+this.getName()+"] Val["+val+"]";
			LoggerManager.getWebGenericProjectLogger().debug(message);
			
			
			Method method = null;
			Object ret = null;
			if(this.getHandlerMethodPrefix() == null){
				methodName = this.getName() + CostantiForm.AUTO_COMPLETE_EVENT_HANDLER;
				method =  this.form.getClass().getMethod(methodName , Object.class);
				ret = method.invoke(this.form,val);
			}else {
				methodName = this.getHandlerMethodPrefix() + CostantiForm.AUTO_COMPLETE_EVENT_HANDLER;
				method =  this.form.getClass().getMethod(methodName , BaseFormField.class, Object.class);
				ret = method.invoke(this.form,this,val);
			}

			if(ret != null && ret instanceof List<?>)
				return (List<?>) ret;
		}catch(NoSuchMethodException e){
			try {
				LoggerManager.getWebGenericProjectLogger().debug("Implementare il metodo ["+methodName+"] per utilizzare l'action listener fieldAutocomplete per il field ["+this.getName()+"]");
			} catch (Exception e1) {
			}
		}catch(Exception e){
			
		}
		return null;
	}

	// Event Handler per la selezione 
	public void fieldSelected(ActionEvent ae) {
		String methodName = null;
		try{
			String message = "fieldSelected Source["+ae.getComponent().getId()+"]";
			LoggerManager.getWebGenericProjectLogger().debug(message);
			
			Method method = null;
			if(this.getHandlerMethodPrefix() == null){
				methodName = this.getName() + CostantiForm.SELECTED_ELEMENT_EVENT_HANDLER;
				method =  this.form.getClass().getMethod(methodName , ae.getClass());
				method.invoke(this.form,ae);
			}else {
				methodName = this.getHandlerMethodPrefix() + CostantiForm.SELECTED_ELEMENT_EVENT_HANDLER;
				method =  this.form.getClass().getMethod(methodName , BaseFormField.class, ae.getClass());
				method.invoke(this.form,this,ae);
			}
		}catch(NoSuchMethodException e){
			try {
				LoggerManager.getWebGenericProjectLogger().debug("Implementare il metodo ["+methodName+"] per utilizzare l'action listener fieldSelected per il field ["+this.getName()+"]");
			} catch (Exception e1) {
			}
		}catch(Exception e){

		}
	}

	// Event Handler per l'evento OnChange 
	public void valueChanged(ValueChangeEvent ae) {
		String methodName = null;
		try{
			String message = "valueChanged Source["+ae.getComponent().getId()+"] OldValue["+ae.getOldValue()+"] NewValue["+ae.getNewValue()+"]";
			LoggerManager.getWebGenericProjectLogger().debug(message);
			
			Method method = null;
			if(this.getHandlerMethodPrefix() == null){
				methodName = this.getName() + CostantiForm.VALUE_CHANGED_EVENT_HANDLER;
				method =  this.form.getClass().getMethod(methodName , ae.getClass());
				method.invoke(this.form,ae);
			}else {
				methodName = this.getHandlerMethodPrefix() + CostantiForm.VALUE_CHANGED_EVENT_HANDLER;
				method =  this.form.getClass().getMethod(methodName , BaseFormField.class, ae.getClass());
				method.invoke(this.form,this,ae);
			}
		}catch(NoSuchMethodException e){
			try {
				LoggerManager.getWebGenericProjectLogger().debug("Implementare il metodo ["+methodName+"] per utilizzare l'action listener valueChanged per il field ["+this.getName()+"]");
			} catch (Exception e1) {
			}
		}catch(Exception e){

		}
	}
	
	// Event Handler per il tag a4j:ajax
		public void listener(AjaxBehaviorEvent ae) {
			String methodName = null;
			try{
				String message = "A4j:ajax Source["+ae.getComponent().getId()+"] Behavior["+ae.getBehavior().toString()+"]";
				LoggerManager.getWebGenericProjectLogger().debug(message);
				
				
				
//				String methodName = null;
//				Method method = null;
//				if(this.getHandlerMethodPrefix() == null){
//					methodName = this.getName() + CostantiForm.ONCHANGE_EVENT_HANDLER;
//					method =  this.form.getClass().getMethod(methodName , ae.getClass());
//					method.invoke(this.form,ae);
//				}else {
//					methodName = this.getHandlerMethodPrefix() + CostantiForm.ONCHANGE_EVENT_HANDLER;
//					method =  this.form.getClass().getMethod(methodName , BaseFormField.class, ae.getClass());
//					method.invoke(this.form,this,ae);
//				}
			}catch(NoSuchMethodException e){
				try {
					LoggerManager.getWebGenericProjectLogger().debug("Implementare il metodo ["+methodName+"] per utilizzare l'action listener 'A4j:ajax' per il field ["+this.getName()+"]");
				} catch (Exception e1) {
				}
			}catch(Exception e){
				try {
					LoggerManager.getWebGenericProjectLogger().error(e, e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		}

	@Override
	public String get_value_type() {
		if(this.type == null){
	    	return null;
	    }else{
	    	return this.type.toString();
	    }
	}

	@Override
	public void set_value_type(String _value_type) {
		this.type = (FieldType) FieldType.toEnumConstantFromString(_value_type);
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public void setId(String id) {
		this.id  =id;
	}
	
	@Override
	public String getStyleClass() {
		return this.styleClass;
	}

	@Override
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
	public Integer getMaxSelectItemsWidth() {
		return this.maxSelectItemsWidth;
	}

	public void setMaxSelectItemsWidth(Integer maxSelectItemsWidth) {
		this.maxSelectItemsWidth = maxSelectItemsWidth;
	}

	public Integer getDefaultSelectItemsWidth() {
		return this.defaultSelectItemsWidth;
	}

	public void setDefaultSelectItemsWidth(Integer defaultSelectItemsWidth) {
		this.defaultSelectItemsWidth = defaultSelectItemsWidth;
	}

	public Integer getSelectItemsWidth() {
		return checkWidthLimits(this.selectItemsWidth);
	}

	public void setSelectItemsWidth(Integer selectItemsWidth) {
		this.selectItemsWidth = selectItemsWidth;
	}

	public boolean isCheckItemWidth() {
		return this.checkItemWidth;
	}

	public void setCheckItemWidth(boolean checkItemWidth) {
		this.checkItemWidth = checkItemWidth;
	}

	private Integer checkWidthLimits(Integer value){
		if(this.checkItemWidth){
			// valore deve essere minore del max ma almeno maggiore del default
			Integer toRet = Math.max(this.defaultSelectItemsWidth, value);

			toRet = Math.min(toRet, this.maxSelectItemsWidth);

			return toRet;
		}else 
			return value;
	}
	
	public List<SelectItem> getElencoSelectItems() {
		return this.elencoSelectItems;
	}
	
	public void setElencoSelectItems(List<javax.faces.model.SelectItem> elencoSelectItems) {
		this.elencoSelectItems = elencoSelectItems;
		if(this.checkItemWidth){
			this.selectItemsWidth = 0;
			for (javax.faces.model.SelectItem selectItem : elencoSelectItems) {
				Object obj	= selectItem.getValue();
				if(obj instanceof SelectItem){
					SelectItem item = (SelectItem) obj;
					String label = item.getLabel();

					int lunghezza = getFontWidth(label);
					this.selectItemsWidth = Math.max(this.selectItemsWidth,  lunghezza);
				}
			}

		}
	}

	public List<org.openspcoop2.generic_project.web.input.SelectItem> getOptions() {
		return this.elencoHtmlOptions;
	}

	public void setOptions(List<org.openspcoop2.generic_project.web.input.SelectItem> elencoHtmlOptions) {
		this.elencoHtmlOptions = elencoHtmlOptions;
	}
}
