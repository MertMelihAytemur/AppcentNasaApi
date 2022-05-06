package com.example.appcentnasaapi.ui.home.rovers.curiosity

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcentnasaapi.R
import com.example.appcentnasaapi.databinding.DialogPhotoDetailBinding
import com.example.appcentnasaapi.databinding.FragmentCuriosityBinding
import com.example.appcentnasaapi.model.roverResponse.Photo
import com.example.appcentnasaapi.ui.adapter.RoverAdapter
import com.example.appcentnasaapi.util.base.BaseFragment
import com.example.appcentnasaapi.util.extensions.OnItemClickListener
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CuriosityFragment : BaseFragment<FragmentCuriosityBinding, CuriosityViewModel>(
    FragmentCuriosityBinding::inflate
) {
    override val viewModel by viewModels<CuriosityViewModel>()
    private var photoList: MutableList<Photo> = mutableListOf()
    private var cameraId: String = "fhaz" //inital value
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateFinished() {
        viewModel.getCuriosityPhotos(cameraId,page.toString())
        setRecyclerViewAdapter()
    }

    override fun initListeners() {}

    override fun observeEvents() {
        with(viewModel) {
            roverResponse?.observe(viewLifecycleOwner, Observer {
                it?.let {
                    it.photos?.let {
                        it.forEach { photo ->
                            photoList.add(photo)
                        }
                    }
                }
                (binding.rvCuriosity.adapter as RoverAdapter).updateList(photoList)
            })
            isLoading.observe(viewLifecycleOwner, Observer {
                handleViewActions(it)
            })
            onError.observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            })
        }
    }

    private fun handleViewActions(isLoading: Boolean = false) {
        // binding.rvCuriosity.isVisible = !isLoading
        binding.progressBar.isVisible = isLoading
    }

    private fun getCuriosityPhotos(camera: String) {
        viewModel.getCuriosityPhotos(camera,page.toString())
    }

    private fun setRecyclerViewAdapter() {
        val mLayoutManager = GridLayoutManager(context, 2)
        binding.rvCuriosity.layoutManager = mLayoutManager
        val mAdapter = RoverAdapter(object : OnItemClickListener {
            override fun onClick(photoDetail: Photo) {
                showDetailDialog(photoDetail)
            }
        })
        binding.rvCuriosity.adapter = mAdapter

        //Paging3 & Infinite Scroll
        binding.rvCuriosity.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastPosition =
                    (binding.rvCuriosity.layoutManager as GridLayoutManager).findLastVisibleItemPosition()
                val listSize = binding.rvCuriosity.adapter?.itemCount

                if (listSize == (lastPosition + 1)) {
                    ++page
                    getCuriosityPhotos(cameraId)
                }
            }
        })
    }

    //Fetch photo details and bind with dialog views.
    @SuppressLint("SetTextI18n")
    private fun showDetailDialog(photoDetail: Photo) {
        val photoUrl: String = photoDetail.imgSrc.toString()
        val photoTakenDate: String = photoDetail.earthDate.toString()
        val roverName: String = photoDetail.rover?.name.toString()
        val roverCamera: String = photoDetail.camera?.name.toString()
        val roverStatus: String = photoDetail.rover?.status.toString()
        val roverLandingDate: String = photoDetail.rover?.landingDate.toString()
        val roverLaunchingDate: String = photoDetail.rover?.launchDate.toString()

        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_photo_detail)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val ivPhoto = dialog.findViewById<ImageView>(R.id.ivPhoto)
        val tvPhotoTakenDate = dialog.findViewById<TextView>(R.id.tvPhotoTakenDate)
        val tvRoverName = dialog.findViewById<TextView>(R.id.tvRoverName)
        val tvRoverCamera = dialog.findViewById<TextView>(R.id.tvRoverCamera)
        val tvRoverStatus = dialog.findViewById<TextView>(R.id.tvRoverState)
        val tvRoverLandingDate = dialog.findViewById<TextView>(R.id.tvLandingDate)
        val tvRoverLaunchingDate = dialog.findViewById<TextView>(R.id.tvLaunchingDate)

        Picasso.get().load(photoUrl).into(ivPhoto);
        tvPhotoTakenDate.text = "•Photo Taken Date: $photoTakenDate"
        tvRoverName.text = "•RoverName: $roverName"
        tvRoverCamera.text = "•Camera Name: $roverCamera"
        tvRoverStatus.text = "•Rover Status: $roverStatus"
        tvRoverLandingDate.text = "•Landing Date: $roverLandingDate"
        tvRoverLaunchingDate.text = "•Launching Date: $roverLaunchingDate"

        dialog.window?.let {
            it.attributes.windowAnimations = R.style.SlidingDialogAnimation
        }
        dialog.show()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.removeItem(R.id.pancam)
        menu.removeItem(R.id.minites)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fhaz -> {
                cameraId = item.title.toString()
                selectRoverCamera(cameraId)
            }
            R.id.rhaz -> {
                cameraId = item.title.toString()
                selectRoverCamera(cameraId)
            }
            R.id.mast -> {
                cameraId = item.title.toString()
                selectRoverCamera(cameraId)
            }
            R.id.chemcam -> {
                cameraId = item.title.toString()
                selectRoverCamera(cameraId)
            }
            R.id.mahli -> {
                cameraId = item.title.toString()
                selectRoverCamera(cameraId)
            }
            R.id.mardi -> {
                cameraId = item.title.toString()
                selectRoverCamera(cameraId)
            }
            R.id.navcam -> {
                cameraId = item.title.toString()
                selectRoverCamera(cameraId)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun selectRoverCamera(cameraId : String){
        photoList.clear()
        page = 0
        getCuriosityPhotos(cameraId)
    }
}