package com.hospital.activity;
import java.util.ArrayList;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import com.hospital.activity.item.Item;
import com.hospital.activity.item.SectionItem;
public class Main extends TabActivity {
	static ArrayList<Item> items1=new ArrayList<Item>();
	private static ArrayList<Item> itemsObjectIndication=new ArrayList<Item>();
	static SectionItem sectionIndication1;
	static SectionItem sectionIndication2;
	static SectionItem sectionIndication3;
	static ArrayList<Item> items2=new ArrayList<Item>();
	private static ArrayList<Item> itemsObjectTreatment=new ArrayList<Item>();
	static SectionItem sectionTreatment1;
	static SectionItem sectionTreatment2;
	static SectionItem sectionTreatment3;
	static ArrayList<Item> items3=new ArrayList<Item>();
	private static ArrayList<Item> itemsObjectProvider=new ArrayList<Item>();
	static SectionItem sectionProvider1;
	static SectionItem sectionProvider2;
	static SectionItem sectionProvider3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ErrorReporter errorReporter=new ErrorReporter();
        errorReporter.Init(Main.this);
        errorReporter.CheckErrorAndSendMail(Main.this);
        Resources res=getResources();
        TabHost tabHost=getTabHost();
        TabHost.TabSpec spec;
		Intent intent;
		String tab_1=getResources().getString(R.string.tab_1);
		String tab_2=getResources().getString(R.string.tab_2);
		String tab_3=getResources().getString(R.string.tab_3);
		String tab_4=getResources().getString(R.string.tab_4);
        intent=new Intent().setClass(this, IndicationsLauncher.class);
        spec=tabHost.newTabSpec("onetab").setIndicator(tab_1, res.getDrawable(R.drawable.indications)).setContent(intent);
        tabHost.addTab(spec);
        intent=new Intent().setClass(this, TreatmentsLauncher.class);
        spec=tabHost.newTabSpec("twotab").setIndicator(tab_2, res.getDrawable(R.drawable.treatments)).setContent(intent);
        tabHost.addTab(spec);
        intent=new Intent().setClass(this, ProvidersLauncher.class);
        spec=tabHost.newTabSpec("threetab").setIndicator(tab_3, res.getDrawable(R.drawable.providers)).setContent(intent);
        tabHost.addTab(spec);
        intent=new Intent().setClass(this, FourTab.class);
        spec=tabHost.newTabSpec("fourtab").setIndicator(tab_4, res.getDrawable(R.drawable.analysis)).setContent(intent);        
        tabHost.addTab(spec);
        tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.layout_tabs_choise);
        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.layout_tabs_choise);
        tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.layout_tabs_choise);
        tabHost.getTabWidget().getChildAt(3).setBackgroundResource(R.drawable.layout_tabs_choise);
        tabHost.setCurrentTab(0);
    }
    public static ArrayList<Item> getItemsObject(int i) {
    	ArrayList<Item> itemNeed=new ArrayList<Item>();
    	switch (i) {
    		case 1:
    			if (items1.size()!=0) {
    				items1.clear();
    			}
    			sortItems1(OneTabObject.getItems());
    			itemNeed=items1;
    			break;
    		case 2:
    			if (items2.size()!=0) {
    				items2.clear();
    			}
    			sortItems2(TwoTabObject.getItems());
    			itemNeed=items2;
    			break;
    		case 3:
    			if (items3.size()!=0) {
    				items3.clear();
    			}
    			sortItems3(ThreeTabObject.getItems());
    			itemNeed=items3;
    			break;
    	}
    	return itemNeed;
    }
    public static ArrayList<Item> sortItems1(ArrayList<Item> array) {
    	itemsObjectIndication=array;
		int lengthItems=itemsObjectIndication.size();
		int sectionNum=0;
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectIndication.get(i);
			if (item instanceof SectionItem) {
				sectionNum++;
				switch (sectionNum) {
					case 1:
						sectionIndication1=new SectionItem(IndicationsItem.outSections(sectionNum));
						break;
					case 2:
						sectionIndication2=new SectionItem(IndicationsItem.outSections(sectionNum));
						break;
					case 3:
						sectionIndication3=new SectionItem(IndicationsItem.outSections(sectionNum));
						break;
				}
			}
		}
		Main.items1.add(sectionIndication1);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectIndication.get(i);
			if (item instanceof IndicationsItem) {
				IndicationsItem itemObj=(IndicationsItem) item;
				if (itemObj.idSection==1) {
					Main.items1.add(itemObj);
				}
			}
		}
		Main.items1.add(sectionIndication2);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectIndication.get(i);
			if (item instanceof IndicationsItem) {
				IndicationsItem itemObj=(IndicationsItem) item;
				if (itemObj.idSection==2) {
					Main.items1.add(itemObj);
				}
			}
		}
		Main.items1.add(sectionIndication3);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectIndication.get(i);
			if (item instanceof IndicationsItem) {
				IndicationsItem itemObj=(IndicationsItem) item;
				if (itemObj.idSection==3) {
					Main.items1.add(itemObj);
				}
			}
		}
		return items1;
    }
    public static ArrayList<Item> sortItems2(ArrayList<Item> array) {
    	itemsObjectTreatment=array;
		int lengthItems=itemsObjectTreatment.size();
		int sectionNum=0;
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectTreatment.get(i);
			if (item instanceof SectionItem) {
				sectionNum++;
				switch (sectionNum) {
					case 1:
						sectionTreatment1=new SectionItem(TreatmentsItem.outSections(sectionNum));
						break;
					case 2:
						sectionTreatment2=new SectionItem(TreatmentsItem.outSections(sectionNum));
						break;
					case 3:
						sectionTreatment3=new SectionItem(TreatmentsItem.outSections(sectionNum));
						break;
				}
			}
		}
		Main.items2.add(sectionTreatment1);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectTreatment.get(i);
			if (item instanceof TreatmentsItem) {
				TreatmentsItem itemObj=(TreatmentsItem) item;
				if (itemObj.idSection==1) {
					Main.items2.add(itemObj);
				}
			}
		}
		Main.items2.add(sectionTreatment2);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectTreatment.get(i);
			if (item instanceof TreatmentsItem) {
				TreatmentsItem itemObj=(TreatmentsItem) item;
				if (itemObj.idSection==2) {
					Main.items2.add(itemObj);
				}
			}
		}
		Main.items2.add(sectionTreatment3);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectTreatment.get(i);
			if (item instanceof TreatmentsItem) {
				TreatmentsItem itemObj=(TreatmentsItem) item;
				if (itemObj.idSection==3) {
					Main.items2.add(itemObj);
				}
			}
		}
		return items2;
    }
    public static ArrayList<Item> sortItems3(ArrayList<Item> array) {
    	itemsObjectProvider=array;
		int lengthItems=itemsObjectProvider.size();
		int sectionNum=0;
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectProvider.get(i);
			if (item instanceof SectionItem) {
				sectionNum++;
				switch (sectionNum) {
					case 1:
						sectionProvider1=new SectionItem(ProvidersItem.outSections(sectionNum));
						break;
					case 2:
						sectionProvider2=new SectionItem(ProvidersItem.outSections(sectionNum));
						break;
					case 3:
						sectionProvider3=new SectionItem(ProvidersItem.outSections(sectionNum));
						break;
				}
			}
		}
		Main.items3.add(sectionProvider1);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectProvider.get(i);
			if (item instanceof ProvidersItem) {
				ProvidersItem itemObj=(ProvidersItem) item;
				if (itemObj.idSection==1) {
					Main.items3.add(itemObj);
				}
			}
		}
		Main.items3.add(sectionProvider2);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectProvider.get(i);
			if (item instanceof ProvidersItem) {
				ProvidersItem itemObj=(ProvidersItem) item;
				if (itemObj.idSection==2) {
					Main.items3.add(itemObj);
				}
			}
		}
		Main.items3.add(sectionProvider3);
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) itemsObjectProvider.get(i);
			if (item instanceof ProvidersItem) {
				ProvidersItem itemObj=(ProvidersItem) item;
				if (itemObj.idSection==3) {
					Main.items3.add(itemObj);
				}
			}
		}
		return items3;
    }
}