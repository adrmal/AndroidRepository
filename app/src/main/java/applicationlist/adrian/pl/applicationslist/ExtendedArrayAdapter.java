package applicationlist.adrian.pl.applicationslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ExtendedArrayAdapter extends ArrayAdapter<Element> {

    private Context context;
    private List<Element> elements;
    int resource;

    public ExtendedArrayAdapter(Context context, int resource, List<Element> elements) {
        super(context, resource, elements);

        this.context = context;
        this.elements = elements;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(resource, parent, false);

        TextView elementName = (TextView) view.findViewById(R.id.elementName);
        elementName.setText(elements.get(position).getName());

        ImageView elementImage = (ImageView) view.findViewById(R.id.elementImage);
        elementImage.setImageDrawable(elements.get(position).getIcon());

        if(resource == R.layout.element) {
            TextView elementSize = (TextView) view.findViewById(R.id.elementSize);
            elementSize.setText(Double.toString(elements.get(position).getSize()) + " MB");
        }

        return view;
    }

}
