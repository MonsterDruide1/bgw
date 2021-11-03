import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

//Message
@Serializable
sealed class Message

@Serializable
data class GameMessage(val payload: JsonElement) : Message()

//Request
@Serializable
sealed class Request : Message()

@Serializable
data class CreateGameRequest(val id: String, val password: String) : Request()

@Serializable
data class JoinGameRequest(val id: String, val password: String, val name: String) : Request()

@Serializable
object DisconnectFromGameRequest : Request()

//Response
@Serializable
sealed class Response : Message()

@Serializable
data class GameMessageResponse(val state: GameMessageState) : Response()

@Serializable
data class CreateGameResponse(val state: CreateGameState) : Response()

@Serializable
data class JoinGameResponse(val state: JoinGameState) : Response()

@Serializable
data class DisconnectFromGameResponse(val state: DisconnectFromGameState) : Response()

//State
@Serializable
enum class CreateGameState {
	/**
	 * Created the game successfully.
	 */
	SUCCESS,

	/**
	 * This connection was already associated with a game on the server. No Game was created.
	 */
	ALREADY_ASSOCIATED_WITH_GAME,

	/**
	 * A Game with the specified ID already exists on the server. No Game was created.
	 */
	GAME_WITH_ID_ALREADY_EXISTS,

	/**
	 * Something on the server went wrong. No Game was created.
	 */
	SERVER_ERROR
}

@Serializable
enum class JoinGameState {
	/**
	 * Joined the game successfully.
	 */
	SUCCESS,

	/**
	 * This connection is already associated with a game on the server and can not join another game at this time.
	 * Disconnect from the current game to connect to another game.
	 */
	ALREADY_ASSOCIATED_WITH_GAME,

	/**
	 * No game with the specified id was found on the server.
	 */
	INVALID_ID,

	/**
	 * The specified password was invalid for the game specified by the id.
	 */
	INVALID_PASSWORD,

	/**
	 * Something on the server went wrong.
	 */
	SERVER_ERROR
}

@Serializable
enum class DisconnectFromGameState {
	/**
	 * Disconnected from the game successfully.
	 */
	SUCCESS,

	/**
	 * This connection was not associated with a game.
	 */
	NO_ASSOCIATED_GAME,

	/**
	 * Something on the server went wrong.
	 */
	SERVER_ERROR
}

@Serializable
enum class GameMessageState {
	/**
	 * The message was valid and broadcast to all other connected players.
	 */
	SUCCESS,

	/**
	 * This connection was not associated with a game.
	 */
	NO_ASSOCIATED_GAME,

	/**
	 * The specified JSON schema was not found on the server.
	 * Message was rejected.
	 */
	SCHEMA_NOT_FOUND,

	/**
	 * the payload did not match the specified schema.
	 * Message was rejected.
	 */
	INVALID_JSON,

	/**
	 * Something went wrong on the server.
	 */
	SERVER_ERROR
}

//Notification
@Serializable
sealed class Notification : Message()

@Serializable
data class UserJoinedNotification(val name: String) : Notification()

@Serializable
data class UserDisconnectedNotification(val name: String) : Notification()
