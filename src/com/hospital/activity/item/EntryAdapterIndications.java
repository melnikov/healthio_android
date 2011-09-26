package com.hospital.activity.item;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.hospital.activity.IndicationsItem;
import com.hospital.activity.R;
public class EntryAdapterIndications extends ArrayAdapter<Item> {
	@SuppressWarnings("unused")
	private Context context;
	private ArrayList<Item> items;
	private LayoutInflater vi;
	public EntryAdapterIndications(Context context, ArrayList<Item> items) {
		super(context, 0, items);
		this.context=context;
		this.items=items;
		vi=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v=convertView;
		final Item i=items.get(position);
		if (i!=null) {
			if (i.isSection()) {
				SectionItem si=(SectionItem) i;
				v=vi.inflate(R.layout.list_item_section, null);
				v.setOnClickListener(null);
				int sectionNum=0;
				for (int h=0; h<position; h++) {
					if (items.get(h).isSection()) {
						sectionNum++;
					}
				}
				v.findViewById(R.id.add_form).setTag(new Integer(sectionNum));
				v.setOnLongClickListener(null);
				v.setLongClickable(false);
				final TextView sectionView=(TextView) v.findViewById(R.id.list_item_section_text);
				sectionView.setTextSize(17);
				sectionView.setText(si.getTitle());
			}
			else {
				IndicationsItem ei=(IndicationsItem) i;
				v=vi.inflate(R.layout.list_item_entry, null);
				final TextView title=(TextView) v.findViewById(R.id.list_item_entry_title);
				final TextView subtitle=(TextView) v.findViewById(R.id.list_item_entry_summary);
				if (title!=null) {
					if (ei.severity==-1) {
						String subtitleCheck=ei.subtitle+"";						
						if (subtitleCheck!="") {
							title.setText(ei.title+" ("+ei.subtitle+")");
						}
						else {
							title.setText(ei.title);
						}
					}
					else {
						title.setText(ei.title+" (Severity "+ei.severity+"%)");
					}
				}
				if (subtitle!=null) {
					Locale local=new Locale("en", "EN");
					DateFormat dfDate=DateFormat.getDateInstance(DateFormat.DEFAULT, local);
					SimpleDateFormat dfTime=new SimpleDateFormat("HH:mm");
					Date date=ei.lastUpdateDate;
					String dateResult=dfDate.format(date);
					String timeResult=dfTime.format(date);
					String result=dateResult+", "+timeResult;
					subtitle.setText("Last updated: "+result);					
				}
			}
		}
		return v;
	}
}