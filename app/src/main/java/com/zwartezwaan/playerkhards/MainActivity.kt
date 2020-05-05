package com.zwartezwaan.playerkhards

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MainActivity : AppCompatActivity() {

        var objList = ArrayList<Objex>()
        var adaptyy :ObjAdapt?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        //load the khards
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        objList.add(
            Objex("Edge Sharing 5-Fold Cluster",
                "A cluster of 5 regular tetrahedra, sharing one edge, leaving small gaps between adjacent faces.",
                    R.drawable.edge_sharing_5_fold_cluster, true) )
        objList.add(
            Objex("Edge Sharing 4-Fold Cluster",
                "A cluster of 4 regular tetrahedra, sharing one edge, leaving small gaps between adjacent faces.",
                R.drawable.edge_sharing_4_fold_cluster, true) )
        objList.add(
            Objex("Edge Sharing 3-Fold Cluster",
                "This is a cluster of 3 regular tetrahedra, sharing one edge, leaving small gaps between adjacent faces.",
                R.drawable.edge_sharing_3_fold_cluster, true) )
        objList.add(
            Objex("Vertex Sharing 4-Fold Cluster",
                "A cluster of 8 regular tetrahedra, sharing one vertex, leaving small gaps between adjacent faces.",
                R.drawable.vertex_sharing_4_fold_cluster, false) )

        adaptyy = ObjAdapt(this,objList)
        objexList.adapter = adaptyy
    }

    class ObjAdapt: BaseAdapter{
        var objexListyy = ArrayList<Objex>()
        var contexty:Context?= null
        constructor(contextty: Context, objexList: ArrayList<Objex> ):super (){
            this.objexListyy = objexList
            this.contexty=contextty
        }

        override fun getView(pos0: Int, pos1: View?, pos2: ViewGroup?): View {
            var objyy = objexListyy[pos0]
            var inflatory = contexty!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var mijnUitzicht = inflatory.inflate(R.layout.player_khards, null)
            mijnUitzicht.name.text = objyy.name
            mijnUitzicht.desc.text = objyy.desc
            mijnUitzicht.img.setImageResource(objyy.img)
            return mijnUitzicht
        }

        override fun getItem(post0: Int): Any { objexListyy[0]}

        override fun getItemId(post0: Int): Long {return post0.toLong()  }

        override fun getCount(): Int { return objexListyy.size}

    }
}
