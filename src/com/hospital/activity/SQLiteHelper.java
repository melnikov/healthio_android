package com.hospital.activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class SQLiteHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_NAME="health";
    private static final String INDICATIONS_TABLE_CREATE="CREATE TABLE \"indications\" (\"id\" INTEGER NOT NULL , \"section\" INTEGER NOT NULL , \"name\" VARCHAR NOT NULL , \"description\" VARCHAR NOT NULL , \"startdate\" VARCHAR NOT NULL , \"enddate\" VARCHAR NOT NULL , \"lastupdate\" VARCHAR NOT NULL , \"repeatdate\" INTEGER NOT NULL , \"severity\" INTEGER NOT NULL , \"repeattime\" VARCHAR NOT NULL , \"uid\" INTEGER NOT NULL , \"local_id\" INTEGER NOT NULL );";
    private static final String TREATMENTS_TABLE_CREATE="CREATE TABLE \"treatments\" (\"id\" INTEGER NOT NULL , \"section\" INTEGER NOT NULL , \"name\" VARCHAR NOT NULL , \"description\" VARCHAR NOT NULL , \"startdate\" VARCHAR NOT NULL , \"enddate\" VARCHAR NOT NULL , \"lastupdate\" VARCHAR NOT NULL , \"repeatdate\" INTEGER NOT NULL , \"severity\" INTEGER NOT NULL , \"type\" INTEGER NOT NULL , \"strength\" VARCHAR NOT NULL , \"system\" INTEGER NOT NULL , \"repeattime\" VARCHAR NOT NULL , \"uid\" INTEGER NOT NULL , \"local_id\" INTEGER NOT NULL );";
    private static final String PROVIDERS_TABLE_CREATE="CREATE TABLE \"providers\" (\"id\" INTEGER NOT NULL , \"section\" INTEGER NOT NULL , \"name\" VARCHAR NOT NULL , \"specialty\" INTEGER NOT NULL , \"affiliation\" VARCHAR NOT NULL , \"cityname\" VARCHAR NOT NULL , \"phone\" VARCHAR NOT NULL , \"fax\" VARCHAR NOT NULL , \"email\" VARCHAR NOT NULL , \"rating\" INTEGER NOT NULL , \"uid\" INTEGER NOT NULL , \"local_id\" INTEGER NOT NULL );";
    private static final String OCCASIONS_TABLE_CREATE="CREATE TABLE \"occasions\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , \"local_id\" INTEGER NOT NULL , \"uid\" INTEGER NOT NULL , \"type\" INTEGER NOT NULL , \"year\" INTEGER NOT NULL , \"month\" INTEGER NOT NULL , \"weekday\" INTEGER NOT NULL , \"day\" INTEGER NOT NULL , \"hour\" INTEGER NOT NULL , \"minute\" INTEGER NOT NULL , \"event_id\" INTEGER NOT NULL );";
    private static final String INDICATIONS_DROP="DROP TABLE IF EXISTS \"indications\"";
    private static final String TREATMENTS_DROP="DROP TABLE IF EXISTS \"treatments\"";
    private static final String PROVIDERS_DROP="DROP TABLE IF EXISTS \"providers\"";
    private static final String OCCASIONS_DROP="DROP TABLE IF EXISTS \"occasions\"";    
	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(INDICATIONS_DROP);
		db.execSQL(TREATMENTS_DROP);
		db.execSQL(PROVIDERS_DROP);
		db.execSQL(OCCASIONS_DROP);
		db.execSQL(INDICATIONS_TABLE_CREATE);
		db.execSQL(TREATMENTS_TABLE_CREATE);
		db.execSQL(PROVIDERS_TABLE_CREATE);
		db.execSQL(OCCASIONS_TABLE_CREATE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(INDICATIONS_DROP);
		db.execSQL(TREATMENTS_DROP);
		db.execSQL(PROVIDERS_DROP);
		db.execSQL(OCCASIONS_DROP);
		db.execSQL(INDICATIONS_TABLE_CREATE);
		db.execSQL(TREATMENTS_TABLE_CREATE);
		db.execSQL(PROVIDERS_TABLE_CREATE);
		db.execSQL(OCCASIONS_TABLE_CREATE);
	}
}