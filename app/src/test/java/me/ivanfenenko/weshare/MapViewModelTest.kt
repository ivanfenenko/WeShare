package me.ivanfenenko.weshare

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import me.ivanfenenko.weshare.model.Scooter
import me.ivanfenenko.weshare.usecase.getscooters.GetScootersUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MapViewModelTest {

    @get:Rule
    val taskRule: TestRule = InstantTaskExecutorRule()

    private var schedulerConfiguration = TestSchedulerConfiguration()
    private var getScooterObserver: Observer<List<Scooter>> = mock()

    private var getScootersUseCaseMock: GetScootersUseCase = mock()

    private lateinit var viewModel: MapViewModel

    @Before
    fun setup() {
        viewModel = MapViewModel(
            getScootersUseCaseMock,
            schedulerConfiguration
        )

        viewModel.getScooters().observeForever(getScooterObserver)
    }

    @Test
    fun `When view model is initiated scooters are being loaded`() {
        whenever(getScootersUseCaseMock.execute()).thenReturn(Observable.just(emptyList()))
        viewModel.onViewAttached()

        verify(getScootersUseCaseMock).execute()
    }

    @Test
    fun `When scooters are loaded live data is updated`() {
        val scooterList = fakeScooters()
        whenever(getScootersUseCaseMock.execute()).thenReturn(Observable.just(scooterList))
        viewModel.onViewAttached()

        verify(getScooterObserver).onChanged(scooterList)
    }

}
