package ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.poc.R
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
class SplashFragment : Fragment()
{
    var disposable: Disposable? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        disposable = Completable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe({
                showNextActivity()
            }, {})
        return view
    }
    private fun showNextActivity()
    {
        findNavController().graph.setStartDestination(R.id.homeFragment)
        findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
    }
    override fun onDestroy() {
        disposable?.dispose()
        super.onDestroy()
    }
}