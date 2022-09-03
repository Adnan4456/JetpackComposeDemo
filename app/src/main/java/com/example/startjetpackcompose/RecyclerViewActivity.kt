package com.example.startjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
 import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.startjetpackcompose.ui.theme.StartJetPackComposeTheme
import com.example.startjetpackcompose.utils.User
import com.example.startjetpackcompose.utils.dummyData

class RecyclerViewActivity: ComponentActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartJetPackComposeTheme {

                Surface(color = MaterialTheme.colors.background) {

                    recyclerView(users = dummyData())
                }
            }
        }
    }


    @Composable
    fun EachRow(user: User){
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(15.dp)),
            elevation = 10.dp,
        ) {
            Row(modifier = Modifier.padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.profile_pic) , contentDescription = "profile",
                modifier = Modifier.padding(10.dp)
                    .align(CenterVertically)
                    .size(80.dp)
                    .clip(RoundedCornerShape(CornerSize(10 .dp))))
                Text(text = user.description , modifier = Modifier.padding(8.dp))
            }
        }
    }


    @Composable
    fun recyclerView(users: List<User>){
        LazyColumn{

            items(users) { user ->
                EachRow(user)
            }
        }
    }
}