package fai.edu.mobile;

import fai.edu.mobile.fragment.FragmentAbout;
import fai.edu.mobile.fragment.FragmentBase;
import fai.edu.mobile.fragment.FragmentProfessor;
import fai.edu.mobile.navigation.drawer.CustomDrawerAdapter;
import fai.edu.mobile.navigation.drawer.DrawerItem;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private CustomDrawerAdapter adapter;
	private List<DrawerItem> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// seta o layout de toda a activity.
		// o layout composto por um FrameLayout e um ListView
		// que lista os itens do menu lateral
		setContentView(R.layout.activity_main);

		// inicializando os componentes
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		dataList.add(new DrawerItem(true)); // adiciona um spinner na lista (tem as opções dos usuários)

		// adiciona os itens no array de DrawerItems
		dataList.add(new DrawerItem(getString(R.string.header_favorites))); // adiciona o header na lista
		dataList.add(new DrawerItem(getString(R.string.item_message), R.drawable.ic_action_email));
		dataList.add(new DrawerItem(getString(R.string.item_grades), R.drawable.ic_action_grades));
		dataList.add(new DrawerItem(getString(R.string.item_subjects), R.drawable.ic_action_subjects));
		dataList.add(new DrawerItem(getString(R.string.item_professors), R.drawable.ic_action_professor));

		dataList.add(new DrawerItem(getString(R.string.header_options)));// adiciona outro header na lista
		dataList.add(new DrawerItem(getString(R.string.item_search), R.drawable.ic_action_search));
		dataList.add(new DrawerItem(getString(R.string.item_cloud), R.drawable.ic_action_cloud));
		dataList.add(new DrawerItem(getString(R.string.item_camera), R.drawable.ic_action_camera));
		dataList.add(new DrawerItem(getString(R.string.item_video), R.drawable.ic_action_video));
		dataList.add(new DrawerItem(getString(R.string.item_import_export),	R.drawable.ic_action_import_export));

		dataList.add(new DrawerItem(getString(R.string.header_other))); // adiciona outro header na lista
		dataList.add(new DrawerItem(getString(R.string.item_about), R.drawable.ic_action_about));
		dataList.add(new DrawerItem(getString(R.string.item_help), R.drawable.ic_action_help));

		// cria um adapter customizado com o R.layout.custom_drawer_item para cada item
		// e seta o adapter na lista de itens do menu lateral
		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item, dataList);
		mDrawerList.setAdapter(adapter);
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// a ActionBarDrawerToggle utilizada para tratar o evento de toque no ícone
		// de menu lateral
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu();
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			if (dataList.get(0).isSpinner()
					& dataList.get(1).getTitle() != null) {
				selectDrawerItem(2);
			} else if (dataList.get(0).getTitle() != null) {
				selectDrawerItem(1);
			} else {
				selectDrawerItem(0);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Infla o menu e adiciona os items do menu na actionbar (barra horizontal que fica no topo da app)
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Trata quando um elemento é selecionado (de acordo com o position) no menu lateral
	 *  e altera o Fragment que está sendo exibido na tela.
	 * 
	 * @param position
	 */
	public void selectDrawerItem(int position) {
		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (position) {

		case 2:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList
					.get(position).getImgResID());
			break;
		case 3:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList.get(position)
					.getImgResID());
			break;
		case 4:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList
					.get(position).getImgResID());
			break;
		case 5:
			fragment = new FragmentProfessor();
			break;
		case 7:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList
					.get(position).getImgResID());
			break;
		case 8:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList.get(position)
					.getImgResID());
			break;
		case 9:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList.get(position)
					.getImgResID());
			break;
		case 10:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList
					.get(position).getImgResID());
			break;
		case 11:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList.get(position)
					.getImgResID());
			break;
		case 13:
			fragment = new FragmentAbout();
			break;
			
		case 14:
			fragment = new FragmentBase();
			args.putString(FragmentBase.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentBase.IMAGE_RESOURCE_ID, dataList.get(position)
					.getImgResID());
			break;
		default:
			break;
		}

		// utilize o FragmentManager para substituir o Fragment que está sendo exibido
		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

		mDrawerList.setItemChecked(position, true);
		setTitle(dataList.get(position).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * Chamado quando o start-up da activity termina (depois do onStart() e onRestoreInstanceState(Bundle) invocados)
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sincroniza o estado do menu lateral (aberto/fechado) depois da chamada do onRestoreInstanceState.
		mDrawerToggle.syncState();
	}

	/**
	 * Esse método é chamado quando alguma configuração do dispositivo muda,
	 * por exemplo, mudança do idioma, posição de portrait <-> landscape
	 * enquanto a activity estiver rodando.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// A ação no botão home/up da action bar deveria abrir/fechar o drawer.
		// ActionBarDrawerToggle vai lidar com isso.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return false;
	}

	/**
	 * Listener disparado quando o usuário clica em um item da lista do menu lateral.
	 *
	 */
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (dataList.get(position).getTitle() == null) {
				selectDrawerItem(position);
			}
		}
	}

}
