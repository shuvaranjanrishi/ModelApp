package com.example.blooddonor.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.blooddonor.data.entity.User
import com.example.blooddonor.ui.components.DividerTextComponent
import com.example.blooddonor.ui.components.EmptyDataComponent
import com.example.blooddonor.ui.components.Loader
import com.example.blooddonor.ui.components.NormalTextComponent
import com.example.blooddonor.ui.components.UserPagerComponent
import com.example.blooddonor.ui.navigation.Routes
import com.example.blooddonor.ui.viewmodel.UserViewModel
import com.example.utilities.Result
import okhttp3.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    userViewModel: UserViewModel = hiltViewModel()
) {

    val users by userViewModel.users.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        10
    }

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->

        when (users) {
            is Result.Loading<*> -> {
                Loader()
            }

            is Result.Success<*> -> {
                val data = (users as Result.Success<List<User>>).data
               if(data.isNotEmpty()){
                   UserPagerComponent(page, data[page])
               }else{
                   EmptyDataComponent()
               }
            }

            is Result.Error<*> -> {
                val error = (users as Result.Error<*>)
                Log.e("TAG", "error: " + error.error)
            }

        }

    }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            NormalTextComponent(
                value = user.name + "\n" + user.email + "\n" + user.phone + "\n" + user.website + "\n" + user.address + "\n" + user.username + "\n" + user.company
            )
            Spacer(modifier = Modifier.height(6.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.Gray,
                thickness = 1.dp
            )
        }
    }
}

//@Preview
//@Composable
//fun DefaultPreviewOfSignInScreen() {
//    SignInScreen(hiltv)
//}