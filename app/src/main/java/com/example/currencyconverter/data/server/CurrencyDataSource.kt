package com.example.currencyconverter.data.server

import com.example.currencyconverter.data.toDomainCurrency
import com.example.currencyconverter.data.toDomainRate
import com.example.data.source.RemoteDataSource
import com.example.domain.Currency
import com.example.domain.Rate

class CurrencyDataSource : RemoteDataSource {

    override suspend fun getLatestCurrencies(base: String): Currency {
        return CurrencyDb.service
            .getAllCurrencies("6492278cd3aa049abe1ba64119476c78", base, "GBP,EUR,JPY,BRL").await()
            .toDomainCurrency()
    }
}