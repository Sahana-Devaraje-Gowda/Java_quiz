document.addEventListener('DOMContentLoaded', function(e) {
	
	//signup form validation
	 $('#registrationForm').formValidation({
		    message: 'This value is not valid',
		    feedbackIcons: {},
            fields: {
            	
            	title: {
                    validators: {
                        notEmpty: {
                            message: 'title is required'
                        }
                    }
                },
            	firstName: {
                    validators: {
                        notEmpty: {
                            message: 'first name is required'
                        }
                    }
                },
                lastName: {
                    validators: {
                        notEmpty: {
                            message: 'last name is required'
                        }
                    }
                },
                persondob: {
                  validators: {
                  	notEmpty: {
                          message: 'The Date of Birth is required.'
                       }
                   }
               },
               nationality: {
                   validators: {
                       notEmpty: {
                           message: 'nationality is required'
                       }
                   }
               },
               email: {
                    validators: {
                        notEmpty: {
                            message: 'The email address is required.'
                        },
                        emailAddress: {
                            message: 'The email address you have provided is not a valid address.'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required.'
                        },
                        stringLength: {
                            min: 6,
                            message: 'The new password  minium 6 characters'
                        }
                    }
                },
                reenterpassword: {
                    validators: {
                        notEmpty: {
                            message: 'The confirm password is required.'
                        },
                        identical: {
                            field: 'password',
                            message: 'The  password and confirm password are not the same'
                        }
                    }
                },
               
                userName: {
                    validators: {
                        notEmpty: {
                            message: 'UserName  is required'
                        }
                    }
                },
                IntenededUseOfAccount: {
                    validators: {
                        notEmpty: {
                            message: 'Inteneded Use Of Account is required'
                        }
                    }
                },
                correctAnswer: {
                    validators: {
                        notEmpty: {
                            message: 'Answer  is required'
                        }
                    }
                },
                company: {
                    validators: {
                        notEmpty: {
                            message: 'company name is required'
                        }
                    }
                },
                description: {
                    validators: {
                        notEmpty: {
                            message: 'Exam Description  is required'
                        }
                    }
                },
                question: {
                    validators: {
                        notEmpty: {
                            message: 'Question is required'
                        }
                    }
                },
                a: {
                    validators: {
                        notEmpty: {
                            message: 'Firist  option is required'
                        }
                    }
                },
                b: {
                    validators: {
                        notEmpty: {
                            message: 'Second options  is required'
                        }
                    }
                },
                c: {
                    validators: {
                        notEmpty: {
                            message: 'Third option is required'
                        }
                    }
                },
                d: {
                    validators: {
                        notEmpty: {
                            message: 'Fourth option is required'
                        }
                    }
                },
               
            }
        }
    );
	 
	 
 //login validation
    $('#loginForm').formValidation({
        message: 'This value is not valid',
        feedbackIcons: {},
        fields: {
            
        	email: {
                validators: {
                    notEmpty: {
                        message: '  Email address is required.'
                    },
                    emailAddress: {
                        message: 'Email address you have provided is not a valid address.'
                    }
                }
            },
          password: {
                validators: {
                    notEmpty: {
                        message: 'Password is required.'
                    },
                    stringLength: {
                        min: 6,
                        message: 'Password is minium 6 characters'
                    }
                }
            },
            stayIn: {
                validators: {
                    notEmpty: {
                        message: 'Please select the city.'
                    }
                }
            },
            agreeForTerms: {
                validators: {
                    notEmpty: {
                        message: 'Please select the checkbox.'
                    }
                }
            },
        }
    });
 
	 
	 
});


