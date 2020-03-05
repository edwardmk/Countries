import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edward.countries.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainFragment : Fragment() {
    data class Country(val name: String, val capital: String, val region: String)

    private val client = OkHttpClient()

    private var countries = listOf


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        createCountry("https://restcountries.eu/rest/v2/all")
    }

    fun createCountry(url: String) {
        val client = OkHttpClient()

        val request: Request = Request.Builder()
            .url("https://restcountries-v1.p.rapidapi.com/name/%7Bname%7D")
            .get()
            .addHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "37fc61718cmsha2e29cd36e0e395p149bbajsnab29a62e1016")
            .build()

        val response = client.newCall(request).execute()


    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.activity_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(countries)
        }
    }
    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}