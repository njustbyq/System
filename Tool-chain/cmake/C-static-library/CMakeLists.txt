# Set the minimum version of CMake that can be used
# To find the cmake version run
# $ cmake --version
cmake_minimum_required(VERSION 3.5)

project(hello_binary)

# Create a library
# Generate the static library from the library sources
# The add_library() function is used to create a library from some source files.

# As with the previous example on static libraries, the add_library() function is also used to create a shared library from some source files.
# We can just replace STATIC with SHARED to generate shared library
add_library(hello_library STATIC src/Hello.cpp)

target_include_directories(hello_library PUBLIC ${PROJECT_SOURCE_DIR}/include)

# Create an executable
# Add an executable with the above sources(the library)

add_executable(hello_binary src/main.cpp)

# When creating an executable that will use your library you must tell the compiler about the library. 
# This can be done using the target_link_libraries() function.
# link the new hello_library target with the hello_binary target

target_link_libraries(hello_binary PRIVATE hello_library)