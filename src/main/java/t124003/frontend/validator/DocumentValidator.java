package t124003.frontend.validator;

import java.util.HashMap;

import t124003.backend.model.document.Document;

/**
 * @author Dan
 */
public class DocumentValidator {
	public HashMap<String, String> Validate(Document document) {
    	HashMap<String, String> documentErrors = new HashMap<String, String>();
        
    	String name = document.getName();
    	String description = document.getDescription();

        if(name.length() < 1) {
        	documentErrors.put("name", " Tuhi dokumendi nimi!");
        }
        if(description.length() < 1) {
        	documentErrors.put("description", " Tuhi dokumendi kirjeldus!");
        }
        
        return documentErrors;
    }
}
