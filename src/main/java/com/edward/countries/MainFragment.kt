import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edward.countries.ListAdapter
import com.edward.countries.R
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException


class MainFragment : Fragment() {
    data class Country(var name: String, var capital: String, var region: String)


    private val countries = arrayListOf<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        createCountry()
    }

    fun createCountry() {
        val client = OkHttpClient()
        try {

        val request: Request = Request.Builder()
            .url("https://restcountries-v1.p.rapidapi.com/name/%7Bname%7D")
            .get()
            .addHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "37fc61718cmsha2e29cd36e0e395p149bbajsnab29a62e1016")
            .build()

            val response = client.newCall(request).execute()
            val country = Country("", "", "")

            val jsonData: String = response.body().toString()
            val json = JSONObject(jsonData)

            country.name = json.getString("name")
            country.capital = json.getString("capital")
            country.region = json.getString("capital")

            countries.add(country)
        }
        catch (e: Exception) {

        } catch (e: IOException) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
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
