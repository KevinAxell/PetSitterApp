package com.example.mytestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_pet_sitters_list.*

class PetSittersList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_sitters_list)

        //Mostrar el toolbar
        MyToolBar().show(this,"Sitters",true,true)

        //Mostrar los datos de los cuidadores guardados en local

        val petSitter1 = PetSitter("Phillip","London,United Kindom",
            4.2f,R.drawable.img_user_01,27,"Perros, Gatos","El mejor cuidador","Muy recomendado ","Phillip el mejor")

        val petSitter2 = PetSitter("Vanessa & Ian","Beaune,France",
            4.7f,R.drawable.img_user_02,22,"Pericos, Mapaches","Los mejores cuidadores","Muy recomendados ","Vanessa e Ian los mejores")

        val petSitter3 = PetSitter("Rita & Phil","Disley,United Kindom",
            5.0f,R.drawable.img_user_03,24,"Ratones, Serpientes","Los mejores cuidadores","Muy recomendados ","Rita y Phil los mejores")

        val listPetSitters = listOf(petSitter1,petSitter2,petSitter3)

        val adapter = PetSitterAdapter(this, listPetSitters)

        my_list.adapter = adapter

        my_list.setOnItemClickListener{ parent, view, position, id ->
            val intent = Intent(this,PetSittersActivity::class.java)
            intent.putExtra("petSitter",listPetSitters[position])
            startActivity(intent)
        }
    }
    override fun onBackPressed() {

    }
}