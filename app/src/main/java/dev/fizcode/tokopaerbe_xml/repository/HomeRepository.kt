package dev.fizcode.tokopaerbe_xml.repository

import dev.fizcode.tokopaerbe_xml.datastore.SharedPrefDatastore
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val sharedPrefDatastore: SharedPrefDatastore
) {
}