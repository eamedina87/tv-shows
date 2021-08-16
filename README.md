# TVShows by Erick Medina

TVShows is a test app that displays a list of tv shows and its detail.

The main screen of the app is the tv shows lists in a grid.

The product detail screen has a more detailed view  of the product including its name, rating and summary.

<img src="tv_shows_gif.gif" alt="screen record" style="width:200px;"/>

## Libraries

- [Retrofit](https://square.github.io/retrofit/)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodela)
- [Coroutines](https://developer.android.com/kotlin/coroutines)
- [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
- [MockK](https://mockk.io/)

## Features

* **Architecture:** MVVM with Use Cases.
* **Dependency Injection:** Using Android's Hilt dependency injection library.
* **Pagination:** using Android Paging 3 library
* **REST API:** with Retrofit
* **Testing:** with MockK the repository, use cases and viewmodel are unit-tested.

## License

MIT License

Copyright (c) [2021] [Erick Medina]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.