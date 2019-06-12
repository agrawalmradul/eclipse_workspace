package com.interviews;

import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//{"value":"hello","orderedList":[{"value":"how are you?"},{"value":"i am good", "orderedList":[{"value":"Thanks for asking"},{"value":"You are welcome"}]}]}
public class Wish {
	public static void main(String[] args) {
		String jsonString = "{\"value\":\"hello\",\"orderedList\":[{\"value\":\"how are you?\"},{\"value\":\"i am good\", \"orderedList\":[{\"value\":\"Thanks for asking\"},{\"value\":\"You are welcome\"}]}]}";
		JsonPar obj = new JsonPar();
		String result = obj.formatToHTML(jsonString);
		System.out.println(result);
	}
}

class JsonPar {

	/*
	 * Complete the 'formatToHTML' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING
	 * jsonString as parameter.
	 */

	public String formatToHTML(String jsonString) {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(jsonString);
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println(e);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<body>\n");
		sb.append(" " + (String) json.get("value") + "\n");
		if (json.containsKey("orderedList")) {
			processOrderedList((JSONArray) json.get("orderedList"), sb, 1);
		}
		sb.append("</body>\n");
		return sb.toString();
	}

	private void processOrderedList(JSONArray olist, StringBuilder sb, int indent) {
		String spaces = String.join("", Collections.nCopies(indent, " "));
		sb.append(spaces + "<ol>\n");
		for (Object obj : olist) {
			JSONObject jObj = (JSONObject) obj;
			sb.append(spaces + " " + "<li>\n");
			sb.append(spaces + "  " + jObj.get("value") + "\n");
			if (jObj.containsKey("orderedList")) {
				processOrderedList((JSONArray) jObj.get("orderedList"), sb, indent + 1);
			}
			sb.append(spaces + " " + "</li>\n");
		}
		sb.append(spaces + "</ol>\n");
	}
}
