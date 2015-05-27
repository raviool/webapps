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

        if (name.length() < 1) {
        	documentErrors.put("name", " Tuhi dokumendi nimi!");
        } else if (name.matches("[0-9]+") && name.length() > 1) {
        	documentErrors.put("name", " Nimi ei tohi sisaldada ainult numbreid!");
        }
        if (description.length() < 1) {
        	documentErrors.put("description", " Tuhi dokumendi kirjeldus!");
        } else if (description.length() > 100) {
        	documentErrors.put("description", " Liiga pikk dokumendi kirjeldus!!");
        }
        
        return documentErrors;
    }
	
	public HashMap<String, String> ValidateSearch(String note) {
    	HashMap<String, String> searchErrors = new HashMap<String, String>();

        if (note.length() < 1) {
        	searchErrors.put("note", " Tuhi dokumendi marge!");
        } else if (note.length() > 100) {
        	searchErrors.put("note", " Liiga pikk dokumendi marge!");
        }
        
        return searchErrors;
    }
}
