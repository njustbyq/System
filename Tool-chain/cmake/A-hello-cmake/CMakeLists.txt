# Set the minimum version of CMake that can be used
# To find the cmake version run
# $ cmake --version
cmake_minimum_required(VERSION 3.5)

# set C++ standard
set(CMAKE_CXX_STANDARD 11)

# Set the project name
project (first_cmake)

# Add executable
# You can add a .cpp source file to compile
add_executable(main_cmake main.cpp)
add_executable(hello_cmake hello.cpp)