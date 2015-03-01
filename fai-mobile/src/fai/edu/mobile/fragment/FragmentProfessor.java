package fai.edu.mobile.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import fai.edu.mobile.R;
import fai.edu.mobile.adapter.ProfessorListAdapter;
import fai.edu.mobile.model.Professor;

public class FragmentProfessor extends Fragment {
	
	private ListView listViewProfessor;
	
	/**
	 * Este é o Fragment utilizado na tela de "Professors".
	 * Repare que o conteúdo da lista está "hard coded" aqui.
	 * Poderia estar vindo de um banco de dados do Android 
	 * ou de um web service, por exemplo.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_professors, container, false);

		//lista de http://venturevillage.eu/who-are-the-worlds-most-influential-tech-names
		List<Professor> professorList = new ArrayList<Professor>();
		String[] profDescriptions = getResources().getStringArray(R.array.professors_description);
		if (profDescriptions != null) {
			for (int i = 0; i < profDescriptions.length; i++) {
				String[] item = profDescriptions[i].split(":::");
				if (item != null && item.length == 3) {
					professorList.add(new Professor(item[0], item[1], item[2].trim()));
				}
			}
		}

		listViewProfessor = (ListView) view.findViewById( R.id.professors_list);
		listViewProfessor.setAdapter( new ProfessorListAdapter(this.getActivity(), R.layout.professor_list_item, professorList));

		listViewProfessor.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Professor o = (Professor) parent.getItemAtPosition(position); 
				Toast.makeText(FragmentProfessor.this.getActivity(), o.getDetails().toString(), Toast.LENGTH_LONG).show();
			}
		});
		
		return view;
	}

}
