//
//  SignupViewModel.swift
//  Kurir
//
//  Created by Loren on 1/9/19.
//  Copyright © 2019 Crazybean Studio. All rights reserved.
//

import Foundation
import MobileSDK
import Mobilex

class SignupViewModel: ViewModel {
    private let repository: AuthRepository?
    
    init(_ repository: AuthRepository?) {
        self.repository = repository
    }
    
    func register(user: User)-> LiveData<Auth?> {
        return LiveData<Auth?>() { [weak self] liveData in
            if let repository = self?.repository {
                repository.register(user: user, callback: { auth in
                    liveData.value = auth
                })
            }
        }
    }
}
