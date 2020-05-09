package com.zwartezwaan.playerkhards

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.player_khards.view.*

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
        objListhehe.adapter = adaptyy }

    fun addyy(indexsh:Int){
        objList.add(indexsh, objList[indexsh])
        adaptyy!!.notifyDataSetChanged()
    }

    fun eraseyy(indexyy:Int){
        objList.removeAt(indexyy)
        adaptyy!!.notifyDataSetChanged() }

   inner class ObjAdapt: BaseAdapter{
        var objexListyy = ArrayList<Objex>()
        var contexty:Context?= null
        constructor(contextty: Context, objexList: ArrayList<Objex> ):super (){
            this.objexListyy = objexList
            this.contexty=contextty }

        override fun getView(pos0: Int, pos1: View?, pos2: ViewGroup?): View {
            var objyy = objexListyy[pos0]
            if (objyy.edged == true){
                var inflatory = contexty!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var mijnUitzicht = inflatory.inflate(R.layout.edged, null)
                mijnUitzicht.nameE.text = objyy.name!!
                mijnUitzicht.descE.text = objyy.desc!!
                mijnUitzicht.imgE.setImageResource(objyy.img!!)
                mijnUitzicht.imgE.setOnClickListener{
                    var intenty = Intent(contexty, KhardInfo::class.java)
                    intenty.putExtra("nameHehe", objyy.name!!)
                    intenty.putExtra("descHehe", objyy.desc!!)
                    intenty.putExtra("imgHehe", objyy.img!!)
                    contexty!!.startActivity(intenty)
                    addyy(pos0)
                }
                return mijnUitzicht
            }
            else{
            var inflatory = contexty!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var mijnUitzicht = inflatory.inflate(R.layout.player_khards, null)
            mijnUitzicht.nameE.text = objyy.name!!
            mijnUitzicht.descE.text = objyy.desc!!
            mijnUitzicht.imgE.setImageResource(objyy.img!!)
                mijnUitzicht.imgE.setOnClickListener{
                    var intenty = Intent(contexty, KhardInfo::class.java)
                    intenty.putExtra("nameHehe", objyy.name!!)
                    intenty.putExtra("descHehe", objyy.desc!!)
                    intenty.putExtra("imgHehe", objyy.img!!)
                    contexty!!.startActivity(intenty)
                    addyy(pos0)
                }
            return mijnUitzicht   }
        }

        override fun getItem(post0: Int): Any { return objexListyy[0]}

        override fun getItemId(post0: Int): Long {return post0.toLong()  }

        override fun getCount(): Int { return objexListyy.size}

    }
}
