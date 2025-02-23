Case Study


Architecture(MVVM)

```
com.example.fakestore
 ├── adapter
 │   └── ProductAdapter.kt     # RecyclerView Adapter + image loading with Glide
 ├── api
 │   ├── ProductApi.kt          # Retrofit endpoint definition
 │   └── RetrofitInstance.kt    # Singleton Retrofit configuration
 ├── model
 │   └── Product.kt             # Data class for the product (Model)
 ├── repository
 │   └── ProductRepository.kt   # Manages API calls (Repository)
 ├── ui
 │   └── MainActivity.kt       # Main screen (View)
 └── viewmodel
     └── ProductViewModel.kt    # ViewModel, manages LiveData
```

Model
Product.kt → Data class representing product information coming from the FakeStore API.

View (UI)
MainActivity.kt → The main screen displaying the product list.
ProductAdapter.kt → Binds each product card to be displayed in the RecyclerView.
XML files (activity_main.xml, item_product.xml) → Visual definitions of UI components.

ViewModel
ProductViewModel.kt → Manages data coming from the API, uses LiveData to update the UI.

Repository

ProductRepository.kt → Handles data flow between the ViewModel and the API, executes Retrofit calls.
This structure ensures loose coupling between Model and View components and increases testability.


Technologies Used

Retrofit
Description: A library developed by Square to simplify HTTP requests.

Usage:

In RetrofitInstance.kt, we define BASE_URL = "https://fakestoreapi.com/".
In ProductApi.kt, we specify endpoints such as @GET("products").
In ProductRepository.kt, this API is called to fetch data and provide it to the ViewModel.



Glide
Description: A library for image loading and caching.

Usage:

In ProductAdapter.kt, use Glide.with(context).load(url).into(imageView) to download product images into an ImageView.
Reduces performance issues and repeated downloads.



RecyclerView
Description: An Android component for efficiently displaying lists or grids.

Usage:

In MainActivity.kt, set up a vertical list with LinearLayoutManager.
In ProductAdapter.kt, manage data binding and ViewHolder logic.

ViewBinding
Description: A mechanism that makes views defined in XML safer and more accessible.

Usage:

In build.gradle, enable buildFeatures { viewBinding = true }.
In MainActivity.kt and adapter files, use inflate(...) to create binding objects (e.g., ItemProductBinding).





How It Works?

When the App Launches:
MainActivity (View) requests data from ProductViewModel.

ViewModel:
The fetchProducts() method initiates an API call via ProductRepository.

Repository:
Calls RetrofitInstance.api.getProducts() to retrieve the JSON response from the FakeStore API and convert it into a Product list.

When Data Arrives:
The ViewModel updates LiveData<List<Product>>.
Since MainActivity observes this list, it automatically updates and provides the new list to the RecyclerView adapter.

On the Screen:
ProductAdapter uses the item_product.xml layout for each product item, downloads images with Glide, and assigns values to components like TextView.
Thus, the user sees the product list (images, names, prices, descriptions) on the main screen.
 
 
 

Screenshots

An example project layout applying the MVVM architecture.
 
![Picture1](Screenshots/Picture1.png)
![Picture2](Screenshots/Picture2.png)
![Picture1](Screenshots/Picture3.png)
![Picture2](Screenshots/Picture4.png)
![Picture1](Screenshots/Picture5.png)
![Picture2](Screenshots/Picture6.png)


