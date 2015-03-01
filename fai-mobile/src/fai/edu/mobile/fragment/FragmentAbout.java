package fai.edu.mobile.fragment;

import fai.edu.mobile.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentAbout extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		//esse Fragment utilizado na tela about.
		// Nenhum conteúdo é atualizado aqui dinamicamente, apenas
		// o layout estático é renderizado na tela.
		return inflater.inflate(R.layout.fragment_about, container, false);
	}
}
