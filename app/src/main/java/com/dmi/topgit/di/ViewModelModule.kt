
package  com.dmi.topgit.di


import dagger.Module
import android.arch.lifecycle.ViewModel
import dagger.multibindings.IntoMap
import dagger.Binds
import android.arch.lifecycle.ViewModelProvider

import com.dmi.topgit.viewmodel.ListViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class) // PROVIDE YOUR OWN MODELS HERE
    internal abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}