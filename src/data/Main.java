package data;

import java.util.Calendar;
import java.util.List;
import java.util.TreeSet;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongo = new MongoClient("localhost:27017");
		MongoDatabase db = mongo.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("news");
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		
		from.set(2016, 0, 1);
		to.set(2017, 0, 1);
		
		String path = "D:\\PPT\\news\\";
		String category = "culture";
		
		JSONReader jsonReader = new JSONReader();
		
		TreeSet<String> fileSet = jsonReader.makeFileName(path, category, from, to);
		List<Document> documents = jsonReader.setDocumentList(fileSet, JSONReader.NEWS_JSON);
		
		collection.insertMany(documents);
		System.out.println("insert끝!");
	}

}
