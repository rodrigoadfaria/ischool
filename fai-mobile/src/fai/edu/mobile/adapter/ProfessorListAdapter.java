package fai.edu.mobile.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fai.edu.mobile.R;
import fai.edu.mobile.model.Professor;

public class ProfessorListAdapter extends ArrayAdapter<Professor> {
	
	private int resource;
	//o Context é utilizado em vários pontos da aplicação
	// e é utilizado para que o Android consiga saber de onde veio uma chamada
	// para que a pilha de activities possa ser gerenciada corretamente
	// pelo sistema do Android
	private Context mContext;
	
	/**
	 * Adapter utilizado no Fragment que lista os professores
	 * @param ctx
	 * @param resourceId
	 * @param objects
	 */
	public ProfessorListAdapter (Context ctx, int resourceId, List<Professor> objects) {
		super(ctx, resourceId, objects);
		resource = resourceId;
		mContext = ctx;
	}
	
	@Override
	public View getView ( int position, View convertView, ViewGroup parent ) {
		ViewHolder holder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = (RelativeLayout) inflater.inflate(resource, parent, false);

			holder = new ViewHolder();
			holder.mProfessorName = (TextView) convertView.findViewById(R.id.prof_name);
			holder.mProfessorCareer = (TextView) convertView.findViewById(R.id.prof_career);
			holder.mProfessorImage = (ImageView) convertView.findViewById(R.id.prof_image);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		Professor teacher = getItem( position );
		holder.mProfessorName.setText(teacher.getName());
		holder.mProfessorCareer.setText(teacher.getDetails());
		
		String uri = "raw/" + teacher.getImage();
		int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());
		Drawable image = mContext.getResources().getDrawable(imageResource);
		holder.mProfessorImage.setImageDrawable(image);
		
		return convertView;
	}
	
	/**
	 * ViewHolder is a android pattern<br/>
	 * Google: A ViewHolder object stores each of the component views inside the tag field of the Layout, 
	 * so you can immediately access them without the need to look them up repeatedly.
	 * First, you need to create a class to hold your exact set of views.
	 * 
	 * <br/><br/><b>See also</b><br/>
	 * <a href="http://developer.android.com/training/improving-layouts/smooth-scrolling.html">Improving layouts: smooth scrolling</a>
	 */
	private static class ViewHolder {
		private TextView mProfessorName, mProfessorCareer;
		private ImageView mProfessorImage;
	}
}
